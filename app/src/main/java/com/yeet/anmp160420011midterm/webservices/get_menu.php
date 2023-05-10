<?php
$resto_id = 1;
$menu_arr = array();

if (isset($_GET['resto_id'])) {
    $resto_id = $_GET['resto_id'];

    if ($resto_id == 1) {
        $menu1 = array(
            'id' => 1,
            'menu_name' => 'Cafe Latte',
            'price' => 35000,
            'menu_img' => 'https://i.gojekapi.com/darkroom/gofood-indonesia/v2/images/uploads/ee2bffa2-9709-4ac2-b850-50c6a756c930_menu-item-image_1626142382479.jpg',
            'desc' => 'Milk with one shot of espresso (Iced/Hot)'
        );

        $menu2 = array(
            'id' => 2,
            'menu_name' => 'Aren Latte',
            'price' => 35000,
            'menu_img' => 'https://i.gojekapi.com/darkroom/gofood-indonesia/v2/images/uploads/9f8908fa-69ce-4f5a-aa00-6d353354d268_menu-item-image_1626142371825.jpg',
            'desc' => 'Milk with one shot of espresso and Brown Sugar (Iced/Hot)'
        );

        $menu3 = array(
            'id' => 3,
            'menu_name' => 'Americano',
            'price' => 28000,
            'menu_img' => 'https://i.gojekapi.com/darkroom/gofood-indonesia/v2/images/uploads/8d92c9b2-4a73-4ec6-83f2-d1223cb2468b_menu-item-image_1626142464413.jpg',
            'desc' => 'One shot of espresso with water (Iced/Hot)'
        );

        $menu4 = array(
            'id' => 4,
            'menu_name' => 'Espresso',
            'price' => 20000,
            'menu_img' => 'https://i.gojekapi.com/darkroom/gofood-indonesia/v2/images/uploads/c6a31245-4829-41bf-b32d-317465860fb9_menu-item-image_1626142671777.jpg',
            'desc' => 'One shot of espresso (Hot)'
        );

        $menu_arr = array($menu1, $menu2, $menu3, $menu4);
        
    } else if ($resto_id == 2) {
        $menu1 = array(
            'id' => 9,
            'menu_name' => 'Ayam Goreng',
            'price' => 15000,
            'menu_img' => 'https://i.gojekapi.com/darkroom/gofood-indonesia/v2/images/uploads/74929c0e-fd83-472c-966d-5f1b0b1f40cc_Go-Biz_20221010_144431.jpeg',
            'desc' => 'Ayam yang di Goreng'
        );

        $menu2 = array(
            'id' => 10,
            'menu_name' => 'Ayam Goreng dengan Nasi',
            'price' => 14000,
            'menu_img' => 'https://i.gojekapi.com/darkroom/gofood-indonesia/v2/images/uploads/e980e201-0bc4-43bd-80f1-38ef728d5083_Go-Biz_20220131_124449.jpeg',
            'desc' => 'Ayam yang di goreng sama pakek nasi'
        );

        $menu3 = array(
            'id' => 11,
            'menu_name' => 'Ayam Goreng Boneless',
            'price' => 15000,
            'menu_img' => 'https://i.gojekapi.com/darkroom/gofood-indonesia/v2/images/uploads/27366839-b81b-48a8-afe7-408fa009abf1_Go-Biz_20220316_132534.jpeg',
            'desc' => 'Ayam yang di goreng tapi nggak pake to the bone'
        );

        $menu4 = array(
            'id' => 12,
            'menu_name' => 'Ayam Goreng Boneless dengan Nasi',
            'price' => 17000,
            'menu_img' => 'https://i.gojekapi.com/darkroom/gofood-indonesia/v2/images/uploads/87922a5c-8329-4bef-ad36-9a4d139347ba_Go-Biz_20220121_103158.jpeg',
            'desc' => 'Ayam yang di goreng tapi nggak pake to the bone tapi pakek nasi'
        );

        $menu_arr = array($menu1, $menu2, $menu3, $menu4);
        
    } else if ($resto_id == 3) {
        $menu1 = array(
            'id' => 5,
            'menu_name' => 'Nasi Goreng',
            'price' => 15000,
            'menu_img' => 'https://i.gojekapi.com/darkroom/gofood-indonesia/v2/images/uploads/d4e8fa6d-9232-45e9-b390-3616472d8cf4_Go-Biz_20220528_124703.jpeg',
            'desc' => 'Nasi yang di Goreng'
        );

        $menu2 = array(
            'id' => 6,
            'menu_name' => 'Mie Goreng',
            'price' => 15000,
            'menu_img' => 'https://i.gojekapi.com/darkroom/gofood-indonesia/v2/images/uploads/4dfda750-54e8-4c73-a3a7-ec33acf6535d_Go-Biz_20220528_130801.jpeg',
            'desc' => 'Mie yang di Goreng'
        );

        $menu3 = array(
            'id' => 7,
            'menu_name' => 'Kwetiau Goreng',
            'price' => 15000,
            'menu_img' => 'https://i.gojekapi.com/darkroom/gofood-indonesia/v2/images/uploads/cc356efb-b480-4d8c-93ab-2053492c4368_Go-Biz_20220528_124948.jpeg',
            'desc' => 'Kwetiau yang di Goreng'
        );

        $menu4 = array(
            'id' => 8,
            'menu_name' => 'Nasi Campur',
            'price' => 17000,
            'menu_img' => 'https://i.gojekapi.com/darkroom/gofood-indonesia/v2/images/uploads/f0232be7-75b8-4298-973f-2d30bb53eefc_Go-Biz_20220801_072503.jpeg',
            'desc' => 'Nasi yang di campur'
        );

        $menu_arr = array($menu1, $menu2, $menu3, $menu4);
        
    } else {
        $menu1 = array(
            'id' => 13,
            'menu_name' => 'Mie Ayam',
            'price' => 14000,
            'menu_img' => 'https://i.gojekapi.com/darkroom/gofood-indonesia/v2/images/uploads/8731aae1-4b59-4353-8153-815df4948650_Go-Biz_20220207_141619.jpeg',
            'desc' => 'Mie dengan ayam'
        );

        $menu2 = array(
            'id' => 14,
            'menu_name' => 'Mie Pangsit',
            'price' => 16000,
            'menu_img' => 'https://i.gojekapi.com/darkroom/gofood-indonesia/v2/images/uploads/cbdb583d-b8eb-4adc-972d-edb92bdf7b48_Go-Biz_20220207_142202.jpeg',
            'desc' => 'Mie dengan pangsit'
        );

        $menu3 = array(
            'id' => 15,
            'menu_name' => 'Mie Bakso',
            'price' => 17000,
            'menu_img' => 'https://i.gojekapi.com/darkroom/gofood-indonesia/v2/images/uploads/d4dc1c59-0056-458e-accc-a03b18bb1eb5_Go-Biz_20220207_141705.jpeg',
            'desc' => 'Mie dengan bakso'
        );

        $menu4 = array(
            'id' => 16,
            'menu_name' => 'Bakso Kuah',
            'price' => 19000,
            'menu_img' => 'https://i.gojekapi.com/darkroom/gofood-indonesia/v2/images/uploads/80626949-e820-414e-a44f-9a264c68e1e8_Go-Biz_20210825_172134.jpeg',
            'desc' => 'Kuah dengan bakso'
        );

        $menu_arr = array($menu1, $menu2, $menu3, $menu4);
        
    }

    echo json_encode($menu_arr);
}

?>