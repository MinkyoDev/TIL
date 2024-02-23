# TIL 20240220

24년 02월 20일 TIL(Today I Learned)

## 1. Discord bot with python

>우선 Discord Developer Portal에 가입해서 애플리케이션을 만들어야 한다.
>만드는 과정은 해당 [블로그](https://yunwoong.tistory.com/212)를 참고하였다.

### 1) main.py
```python
import discord
from discord.ext import commands

intents = discord.Intents.default()
intents.message_content = True
bot = commands.Bot(command_prefix='!', intents=intents)

@bot.event  
async def on_ready():
	await bot.add_cog(HelloCommand(bot))

bot.run('YOUR_BOT_TOKEN')
```

- `4~5` : intents는 bot이 사용할 기능과 관련된 옵션. 사용자 입력에 따라 작동하는 기능을 개발하기 위해서 message_content를 True로 설정.
- `6` : bot의 명령어의 prefix를 정한다. 만약 hello 명령어를 만들고 호출하려고 한다면, !hello를 입력하면 봇이 응답하게 된다.
- `8~10` : bot이 실행되고 준비가 끝나면 실행되는 이벤트. bot.add_cog 메서드로 명령어를 객체지향적으로 개발할 수 있다. 
- `12` : bot을 실행시키는 코드. YOUR_BOT_TOKEN에 인자로 봇의 토큰을 입력.

### 2) hello_command.py
```python
class HelloCommand(commands.Cog):
	def __init__(self, bot):
		self.bot = bot
	
	@commands.group(name='hello')  # 그룹 명령어는 단독으로 호출할 수 없습니다.
	async def hello_group(self, ctx: discord.ext.commands.Context):
		if ctx.invoked_subcommand is None:
			await ctx.send('그룹 명령어는 단독으로 실행될 수 없습니다.') 
	
	@hello_group.command(name='korean')
	async def hello_korean(self, ctx):
		# !hello korean 명령어에 대한 응답을 처리합니다.
		await ctx.send('안녕하세요.')
	
	@hello_korean.error
	async def hello_korean_error(self, ctx, error):
		# 이곳에서 hello_korean 명령어의 오류를 처리합니다.
		await ctx.send(error)
	
	@hello_group.command(name='english')
	async def hello_english(self, ctx):
		# !hello english 명령어에 대한 응답을 처리합니다.
		await ctx.send('hello')
		
	@commands.command(name='hi')  # 단일 명령어는 단독으로 호출합니다.
	async def hi(self, ctx):
	# !hi 명령어에 대한 응답을 처리합니다.
		await ctx.send('hi')
	
	@commands.command(name='hii')  # 명령어 외에 인자를 받을 수 있습니다.
	async def hi_args(self, ctx, *args):
		# args는 튜플 형태로 받습니다.
```

- 위의 코드와 같이 봇이 응답할 메시지는 `ctx.send` 메서드로 보낼 수 있다.
- 명령어는 그룹 명령어와 단일 명령어가 있는데, 그룹 명령어는 명령어를 조합해서 사용할 수 있고, 단일 명령어는 단독으로 사용할 수 있다. 그리고 명령어와 함께 추가 인자를 받고 싶다면 `*args` 가변 인자로 인자를 받아서 원하는 기능을 구현할 수 있습니다.

### 3) my_task.py
```python
async def my_task(bot: discord.ext.commands.Bot):
	while True:
		now = dt.now(datetime.timezone.utc)
		if now.minute == 45 or now.minute == 40:
		# 원하는 일을 합니다.
		
		# 채널 객체 받아오기
		test_channel = bot.get_channel('YOUR_CHANNEL_ID')  # 채널ID는 int             
		await test_channel.send('정해진 시간에 작동합니다.')
	
	await asyncio.sleep(60)
```

- 매 시 40분과 45분에 원하는 일을 하고, 서버의 채널에 메시지를 보낸다. `asyncio.sleep`의 인자는 초 단위이므로 현재는 1분마다 실행되는 함수다.

### 4) main.py에 task 등록
```python
import discord
from discord.ext import commands

intents = discord.Intents.default()
intents.message_content = True
bot = commands.Bot(command_prefix='!', intents=intents)

@bot.event  
async def on_ready():
	await bot.add_cog(HelloCommand(bot))
	bot.loop.create_task(my_task(bot)) # task를 추가합니다.

bot.run('YOUR_BOT_TOKEN')
```

### 5) FastAPI와 Discord bot 연동
```python
from fastapi import FastAPI
import discord
from discord.ext import commands
import asyncio

import hello_command

intents = discord.Intents.default()
intents.message_content = True
app = FastAPI()
bot = commands.Bot(intents=intents, command_prefix="!")    

@app.get("/")
async def hello_world():
	return {"hello": "world"}

@app.get("/send_message")
async def send_message():
	bot.loop.create_task(hello_command.send_message(bot))

@bot.event
async def on_ready():
	print(f"Logged in as {bot.user} running together with FastAPI!")
	await bot.add_cog(hello_command.HelloCommand(bot))

@bot.command()
async def welcome(ctx: commands.Context, member: discord.Member):
	await ctx.send(f"Welcome to {ctx.guild.name}, {member.mention}!")


async def run():
	try:
		await bot.start(TOKEN)
	except KeyboardInterrupt:
		await bot.logout()

asyncio.create_task(run())
```

- `17~19` : Discord 봇이 준비되었을 때 실행되는 이벤트 핸들러. 봇이 로그인하고 준비되었음을 콘솔에 출력하고, `hello_command` 모듈에서 정의된 `HelloCommand` 코그를 봇에 추가한다.
- `31~35` : 메인 함수 `run`을 정의한다. 이 함수는 봇을 시작하는 데 사용되며, `TOKEN`이라는 변수를 사용하여 봇을 로그인 시킨다. 만약 프로그램이 `KeyboardInterrupt` (예: 사용자가 Ctrl+C를 누름)를 통해 중단되면, 봇이 로그아웃하도록 처리한다. `TOKEN`은 봇의 토큰을 나타내는 변수이며, 실제 토큰 값으로 대체되어야 함.

## 참고자료

- [[파이썬] 디스코드 봇 개발하기(명령어, 알람 봇)](https://ouohoon.tistory.com/12)
- [Python으로 Discord Bot 만들기 (1)](https://yunwoong.tistory.com/212)
- [Combining FastAPI and discord.py](https://makubob.medium.com/combining-fastapi-and-discord-py-9aad07a5cfb6)
