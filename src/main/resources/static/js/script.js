$(document).ready(function () {
    $(".dws-form").on("click", ".tab", function() {
        //delete classes active
        $(".dws-form").find(".active").removeClass("active");

        //adding class active
        $(this).addClass("active");
        $(".tab-form").eq($(this).index()).addClass("active");
    })
});