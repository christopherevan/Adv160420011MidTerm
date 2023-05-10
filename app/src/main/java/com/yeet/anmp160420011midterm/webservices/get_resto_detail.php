<?php
$resto_id = 1;
$resto = array();

$arr1 = array(
    'id' => 1,
    'name' => 'Kopi Titik Koma Tenggilis',
    'relative_location' => 'Near Ubaya',
    'location' => 'Jl. Rungkut Mejoyo Utara No.61, Kali Rungkut, Kec. Rungkut, Kota SBY, Jawa Timur 6029',
    'open_hour' => '08.00',
    'close_hour' => '21.00',
    'image_url' => 'https://blogger.googleusercontent.com/img/b/R29vZ2xl/AVvXsEiuYnL5dKVQxDX_l9oO9wqChBblwi1BQT61R4VPq1tgIxDwPbuUf5RKqM269a7eX-DX7-FOOTldLh2KsWrw7j0qF-OaUZWy4pQv_wNutCoYn_ilKz3EMZE7GE4hm25tSlqZTRATUM2pRs67zkDH8SMve_cvUI9KKvrEtPwPio21jkY9fJW7GgWr3cz_/s16000/kopi-titik-koma-surabaya-harga-menu-dan-lokasi.jpg',
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
    'relative_location' => 'Dekat Ubaya',
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
    'relative_location' => 'Dekat Ubaya',
    'location' => 'Jl. Rungkut Mejoyo Utara III Blok AG No.35, Kali Rungkut, Kec. Rungkut, Kota SBY, Jawa Timur 60292',
    'open_hour' => '08.00',
    'close_hour' => '20.00',
    'image_url' => 'https://assets-pergikuliner.com/Gf7KBL1rONz6Tyqg8gLDSdLUJtE=/fit-in/758x598/smart/https://assets-pergikuliner.com/uploads/image/picture/1033904/picture-1534304779.jpg',
    'rating' => 5,
    'count_reviews' => 8
);

if (isset($_GET['resto_id'])) {
    $resto_id = $_GET['resto_id'];

    if ($resto_id == 1) {
        $resto = $arr1;

    } else if ($resto_id == 2) {
        $resto = $arr2;
        
    } else if ($resto_id == 3) {
        $resto = $arr3;    
        
    } else {
        $resto = $arr4;
        
    }

    echo json_encode($resto);
}

?>