data = {
    "chat": [
        {
            "type": "user",
            "content": "대한민국의 수도는?"
        },
        {
            "type": "assistant",
            "content": "대한민국의 수도는 서울입니다."
        },
        {
            "type": "user",
            "content": "진짜야? 확실해?"
        },
        {
            "type": "assistant",
            "content": "table 속성을 사용하여 텍스트의 세로 정렬을 조절할 수 있습니다. display: table 속성을 사용하여 텍스트를 세로 방향으로 정렬할 수 있습니다. "
        }
    ]
}

$(document).ready(function () {
    auto_textarea_height()
    data.chat.forEach(function (item) {
        make_ballons(item.type, item.content);
    });
});

function make_ballons(type, content) {
    var newBallon = `<div class="balloon-box">` +
        `<div class="${type}-balloon">` +
        `<div class="pull"><p>${content}</p></div>` +
        `</div>` +
        `</div>`;
    $('#conv-box').append(newBallon);
}

function auto_textarea_height() {
    $('#prompt-input').on('input', function () {
        var padding = parseFloat($(this).css('padding-top')) + parseFloat($(this).css('padding-bottom'));
        $(this).css('height', 'auto').height((this.scrollHeight - padding) + 'px');
    });

    $('#prompt-input').on('keydown', function(event) {
        if (event.keyCode == 13 && !event.shiftKey) {
            event.preventDefault();
            button_click();
        }
    });

    $('#prompt-button').on('click', function() {
        button_click();
    });

    function button_click() {
        alert("you pressed prompt button!");
    }
}