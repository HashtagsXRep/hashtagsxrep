function hashtagCount(ht, ok, ko) {
    var input = ht.replace('#', '');
    $.ajax({
        url: "/hashtag/" + input + "/count",
        success: ok,
        error: ko,
        dataType: 'json'
    });
}

function submitProposal() {
    var hashtag = $('#hashtag');
    var form = $("#proposalForm");
    hashtagCount(hashtag.val(), function(response) {
        if (response.accepted) {
            form.attr('onsubmit', '');
            form.submit();
        } else {
            var validation = $('#hashtag_validation');
            validation.addClass('error');
            validation.text(response.reason);
            removeValidation('#hashtag');
            hashtag.focus();
            $('html, body').animate({scrollTop: hashtag.offset().top}, 500);
        }
    }, function(err) {
        form.attr('onsubmit', '');
        form.submit();
    });
    return false;
}

function removeValidation(selector) {
    var timeoutId = setTimeout(function() {
        var validation = $(selector+'_validation');
        validation.removeClass('error');
        validation.text('');
        clearTimeout(timeoutId);
    }, 10000);
}

function setValue(id, value) {
    $('#'+id).val(value);
}

function go(to) {
    $(window).attr('location', to);
}

console.log(">> app js");
