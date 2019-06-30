function sumTotalPrice(price) {
    $('#input-quantity').on('input', function() {
        $('#total').text(parseFloat(Math.round($(this).val() * price * 100) / 100).toFixed(2))
    });
}
