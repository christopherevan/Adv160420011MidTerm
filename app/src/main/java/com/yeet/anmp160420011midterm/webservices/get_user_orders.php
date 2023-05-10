<?php
header('Access-Control-Allow-Origin: *');

$arr1 = array(
    'order_id' => '21394309',
    'resto_name' => 'Kopi Titik Koma Tenggilis',
    'count_items' => 2,
    'items' => array('Cafe Latte', 'Americano'),
    'total_price' => 55000,
    'date' => '3 Apr 2023',
    'status' => 'Ongoing'
);

$arr2 = array(
    'order_id' => '21343953',
    'resto_name' => 'Depot LH',
    'count_items' => 1,
    'items' => array('Mie Goreng'),
    'total_price' => 15000,
    'date' => '15 Mar 2023',
    'status' => 'Completed'
);

echo json_encode(array($arr1, $arr2));
?>