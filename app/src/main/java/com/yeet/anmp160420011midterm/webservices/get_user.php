<?php
header('Access-Control-Allow-Origin: *');

$user_arr = array();

if (isset($_GET['username'])) {
    $user_id = $_GET['username'];

    if ($user_id == 'johndoe369') {
        $user1 = array(
            'username' => 'johndoe369',
            'display_name' => 'John Doe',
            'profile_url' => 'https://randomuser.me/api/portraits/men/68.jpg'
        );

        $user_arr = $user1;  
    } 

    echo json_encode($user_arr);
}
?>