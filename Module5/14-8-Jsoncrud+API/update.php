<?php
    
    include('connect.php');
    
     $id = $_POST["id"];
     $p_name = $_POST["p_name"];
     $p_price = $_POST["p_price"];
     $p_des = $_POST["p_des"];
    
    $sql ="update details set p_name='$p_name',p_price='$p_price',p_des='$p_des' where id='$id'";
    
    if(mysqli_query($con,$sql))
    {
        echo 'updated Succesfully';
    }
    else
    {
        echo 'something went wrong';
    }

?>