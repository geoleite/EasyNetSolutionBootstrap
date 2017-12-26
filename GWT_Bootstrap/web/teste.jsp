<html lang="en">
    <head>
        <meta charset="utf-8">
        <title>Date time picker in Input Field using Bootstrap by Lisenme</title>
        <!-- Minified Bootstrap CSS -->
        <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
        <script type="text/javascript" src="https://cdnjs.cloudflare.com/ajax/libs/jquery.mask/1.14.0/jquery.mask.js"></script>
    <body>
        <input type="text" id="CPF" name="CPF" />
        <input type="text" id="PLACA" name="PLACA" />
<script>
    $(document).ready(function () { 
        var $seuCampoCpf = $("#CPF");
        $seuCampoCpf.mask('000.000.000-00', {reverse: false});
    });
    $(document).ready(function () { 
        var $seuCampoPLACA = $("#PLACA");
        $seuCampoPLACA.mask('SSS-0000', {reverse: false});
    });
</script>        
    </body>
</html>