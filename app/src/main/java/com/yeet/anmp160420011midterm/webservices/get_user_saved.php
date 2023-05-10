<?php
header('Access-Control-Allow-Origin: *');

$arr1 = array(
    'id' => 1,
    'name' => 'Kopi Titik Koma Tenggilis',
    'relative_location' => 'Near Ubaya',
    'location' => 'Jl. Rungkut Mejoyo Utara No.61, Kali Rungkut, Kec. Rungkut, Kota SBY, Jawa Timur 6029',
    'open_hour' => '08.00',
    'close_hour' => '21.00',
    'image_url' => 'https://scheday.site/tikom.png',
    'rating' => 4.25,
    'count_reviews' => 5
);

$arr2 = array(
    'id' => 2,
    'name' => 'Ayam Goreng Harvest',
    'relative_location' => 'Kantin Keluwih',
    'location' => 'Kantin Keluwih Lama',
    'open_hour' => '09.00',
    'close_hour' => '17.00',
    'image_url' => 'https://scheday.site/img2.jpg',
    'rating' => 4.5,
    'count_reviews' => 3
);

echo json_encode(array($arr1, $arr2));

?>