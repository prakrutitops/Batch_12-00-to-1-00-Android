<?php

    include('connect.php');
    
    $sql ="Select * from details";
    
    $r = mysqli_query($con,$sql);
    $response = array();
    
    
    while($row = mysqli_fetch_array($r))
    {
        
        $value["id"] = $row["id"];
        $value["p_name"] = $row["p_name"];
        $value["p_price"] = $row["p_price"];
        $value["p_des"] = $row["p_des"];
        
        array_push($response,$value);
    }
    echo json_encode($response);
    mysqli_close($con);
    


?>