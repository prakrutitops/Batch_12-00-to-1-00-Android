<?php
    
    include('connect.php');
    
    $id = $_POST["id"];
    
    $sql ="delete from details where id = '$id'";
    
    if(mysqli_query($con,$sql))
    {
        echo 'deleted Succesfully';
    }
    else
    {
        echo 'something went wrong';
    }

?>