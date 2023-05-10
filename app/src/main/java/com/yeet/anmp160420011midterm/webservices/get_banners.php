<?php
header('Access-Control-Allow-Origin: *');

$arr1 = array(
    'id' => 2,
    'banner_link' => 'https://scheday.site/banner2.jpg',
    'title' => 'Makan enak harga murah',
    'sponsor' => 'Harvest Chicken'
);

$arr2 = array(
    'id' => 1,
    'banner_link' => 'https://i0.wp.com/i.gojekapi.com/darkroom/gofood-indonesia/v2/images/uploads/aac7509f-152d-4df3-87e8-a24657af1608_restaurant-image_1623121796415.jpg',
    'title' => 'Ngopi biar semangat',
    'sponsor' => 'Kopi Titik Koma'
);

$arr3 = array(
    'id' => 4,
    'banner_link' => 'https://assets-pergikuliner.com/7OQiEgO3zjYObBDikANF0BwL4WE=/385x290/smart/https://assets-pergikuliner.com/uploads/image/picture/1634209/picture-1571043604.jpg',
    'title' => 'Makan mie yuk',
    'sponsor' => 'Mie Pinangsia'
);

echo json_encode(array($arr1, $arr2, $arr3));
?>