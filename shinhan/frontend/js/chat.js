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

var side_var_enabled = true;

$(document).ready(function () {
    auto_textarea_height()
    data.chat.forEach(function (item) {
        make_ballons(item.type, item.content);
    });

    $("#side-btn").click(side_var_move)
});

// $(document).on('keydown', function (e) {
//     if (e.which == 13) {
//         e.preventDefault();
//         $('#prompt-input').focus();
//     }
// });

function side_var_move() {
    if (!side_var_enabled) {
        $(this).parent().css("transform", "translate(20px, 0)");
        $("#temp").css("width", "var(--side-bar-width)");
        side_var_enabled = true;
    } else {
        $(this).parent().css("transform", "translate(calc(var(--side-bar-width) * -1), 0)");
        $("#temp").css("width", "0");
        side_var_enabled = false;
    }
}

function set_loding_animation() {
    var animate_comp = '<span class="loading-box"><span class="circles"><i></i><i></i><i></i></span></span>';
    return animate_comp;
}

function make_ballons(type, content) {
    if (type == "loding") {
        type = "assistant";
        content = set_loding_animation();
    }
    var Ballon_format = `<div class="balloon-box balloon-rise">` +
        `<div class="${type}-balloon">` +
        `<div class="pull"><p>${content}</p></div>` +
        `</div>` +
        `</div>`;
    $('#conv-box').append(Ballon_format);

    $('#conv-box').children().last().hide().slideDown(500);
}

function auto_textarea_height() {
    $('#prompt-input').on('input', function () {
        var padding = parseFloat($(this).css('padding-top')) + parseFloat($(this).css('padding-bottom'));
        $(this).css('height', 'auto').height((this.scrollHeight - padding) + 'px');
    });

    $('#prompt-input').on('keydown', function (event) {
        if (event.keyCode == 13 && !event.shiftKey) {
            event.preventDefault();
            button_click();
        }
    });

    $('#prompt-button').on('click', function () {
        button_click();
    });

    function button_click() {
        var prompt = $('#prompt-input').val().trim();
        console.log(prompt);
        if (prompt == "" || $("#prompt-button").prop("disabled")) {
            return;
        }
        make_ballons("user", prompt);
        make_ballons("loding");
        setTimeout(sayHi, 5000, "홍길동", "안녕하세요.");
        $("#prompt-button").prop("disabled", true);
        $("html, body").animate({ scrollTop: $(document).height() }, "slow");
        $('#prompt-input').val("");
        $('#prompt-input').css('height', 'auto')
    }
}

function sayHi(who, phrase) {
    alert( who + ' 님, ' + phrase );
    $("#prompt-button").prop("disabled", false);
  }