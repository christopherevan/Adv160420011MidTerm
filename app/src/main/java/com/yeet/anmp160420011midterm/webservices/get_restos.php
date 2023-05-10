<?php
header("Access-Control-Allow-Origin: *");
$arr = null;
$conn = new mysqli("localhost", "root", "", "u160927_anmpku");

if ($conn->connect_error) {
    $arr = ["result" => "error", "message" => "unable to connect"];
} else {
    $sql = "SELECT * FROM restos";
    $stmt = $conn->prepare($sql);
    // $stmt->bind_param("i", $idkomik);
    $stmt->execute();
    $result = $stmt->get_result();

    $sql2 = "SELECT AVG(rev.rating) FROM reviews AS rev INNER JOIN";
    $stmt2 = $conn->prepare($sql);
    // $stmt->bind_param("i", $idkomik);
    $stmt->execute();
    $result = $stmt->get_result();

    if ($result->num_rows > 0) {
        $data = [];
        while ($r = mysqli_fetch_assoc($result)) {
            array_push($data, $r);
        }
        $arr = ["result" => "success", "data" => $data];
    } else {
        $arr = ["result" => "error", "message" => "sql error: $sql"];
    }
    echo json_encode($arr);
    $stmt->close();
    $conn->close();
}
?>
