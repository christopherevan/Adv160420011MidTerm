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

$arr3 = array(
    'id' => 3,
    'name' => 'Depot LH',
    'relative_location' => 'Near Ubaya',
    'location' => 'Tenggilis Mejoyo AM - 3E, Kota SBY, Jawa Timur 60293',
    'open_hour' => '09.00',
    'close_hour' => '17.00',
    'image_url' => 'https://scheday.site/2.jpeg',
    'rating' => 4,
    'count_reviews' => 8
);

$arr4 = array(
    'id' => 4,
    'name' => 'Mie Pinangsia',
    'relative_location' => 'Near Ubaya',
    'location' => 'Jl. Rungkut Mejoyo Utara III Blok AG No.35, Kali Rungkut, Kec. Rungkut, Kota SBY, Jawa Timur 60292',
    'open_hour' => '08.00',
    'close_hour' => '20.00',
    'image_url' => 'https://assets-pergikuliner.com/Gf7KBL1rONz6Tyqg8gLDSdLUJtE=/fit-in/758x598/smart/https://assets-pergikuliner.com/uploads/image/picture/1033904/picture-1534304779.jpg',
    'rating' => 5,
    'count_reviews' => 8
);

echo json_encode(array($arr1, $arr2, $arr3, $arr4, $arr1, $arr2, $arr3, $arr4));
?>