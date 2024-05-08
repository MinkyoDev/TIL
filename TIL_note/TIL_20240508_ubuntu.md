# TIL 20240508 Ubuntu

24년 05월 08일 TIL(Today I Learned)

## Ubuntu Tutorial

팀프로젝트를 하면서 공동으로 사용할 DB나 FS등이 필요하게 되어서 집에 있는 남는 노트북으로 ubuntu server를 만들게 되었다. 공부용으로 ec2를 사용하기에는 경제적으로 부담되기도 하고 리눅스 공부도 할겸

ubuntu 22.04를 사용할 것이다.

## Install

설치는 인터넷 보고 알아서 하자...

## 고정IP 설정

이 부분에서 약간 애를 먹었다.

```shell
vi /etc/netplan/01-network-manager-all.yaml
```
인터넷의 자료들을 보면 위와 같은 `yaml`파일을 수정하고 나와 있었지만 나의 경우 눈을 씻고 찾아봐도 위의 파일이 없었다.

```shell
cd /etc/netplan 
ls
```
따라서 위의 명령어로 들어가 봤더니

```
00-installer-config-wifi.yaml  00-installer-config.yaml
```
다음과 같은 2개의 파일을 발견할 수 있었다. 처음에는 installer라고 적혀있어서 아닌줄 알았지만 `00-installer-config-wifi.yaml`이 파일을 수정하여 고정ip 설정에 성공하였다.

```vi
# This is the network config written by 'subiquity'
network:
  version: 2
  wifis:
    wlp2s0:
      access-points:
        Yeonsik_2G:
          password: ******
      dhcp4: false
      addresses:
          - 172.30.1.100/24
      routes:
        - to: default
          via: 172.30.1.254

```
최종 수정본이다. 
- `dhcp4`: 처음에는 `true`로 되어있을텐데 `false`로 바꿔준다.
- `addresses`: 원하는 ip를 입력한다.
- `routes: via`: 기본 게이트웨이를 적어준다.

## 대기모드 진입 해제

노트북을 이용하여 서버로 사용하므로 화면이 닫혀있어도 작동해야 했다. 따라서 대기모드를 해제해 주어야 했다.

방법은 다음과 같다. 

```shell
sudo vi /etc/systemd/logind.conf
```
위의 conf파일에서 

```
HandleLidSwitch=ignore
```
`HandleLidSwitch`부분을 `ignore`로 바꿔준다. 주석처리 되어있기 때문에 주석도 해제한 후 저장하면 된다.

```
systemctl restart systemd-logind
```
설정값이 적용되도록 위 명령어를 입력하면 끝이다.

## 참고자료

- [[Raspberry Pi/Ubuntu] 고정 IP 설정하기 (Ubuntu 22.04 LTS)](https://main.tistory.com/280)
- [[Linux] Ubuntu 22.04 고정 IP 설정](https://velog.io/@yesue/Linux-Ubuntu-22.04-%EA%B3%A0%EC%A0%95-IP-%EC%84%A4%EC%A0%95)
- [우분투 노트북 덮개 닫아도 대기모드에 진입하지 않게 설정하기](https://dontdiethere.tistory.com/27)