<?php
$resto_id = 1;
$review_arr = array();

if (isset($_GET['resto_id'])) {
    $resto_id = $_GET['resto_id'];

    if ($resto_id == 1) {
        $rev1 = array(
           'id' => 1,
           'user_name' => 'Kenny G',
           'user_profilepic_url' => 'https://randomuser.me/api/portraits/men/74.jpg',
           'content' => 'I really enjoyed the latte. Would visit again soon!',
           'rating' => 5,
           'date' => '20 Apr 2023'
        );

        $rev2 = array(
           'id' => 2,
           'user_name' => 'Anna',
           'user_profilepic_url' => 'https://randomuser.me/api/portraits/women/74.jpg',
           'content' => 'Coffee and ambiance was very superb.',
           'rating' => 5,
           'date' => '3 Apr 2023'
        );

        $rev3 = array(
            'id' => 3,
            'user_name' => 'John L',
            'user_profilepic_url' => 'https://randomuser.me/api/portraits/men/13.jpg',
            'content' => 'Great service by the staff',
            'rating' => 5,
            'date' => '15 Mar 2023'
        );

        $rev4 = array(
            'id' => 4,
            'user_name' => 'Lisa M',
            'user_profilepic_url' => 'https://randomuser.me/api/portraits/women/37.jpg',
            'content' => 'Delicious coffee!',
            'rating' => 5,
            'date' => '1 Jan 2023'
        );

        $rev_arr = array($rev1, $rev2, $rev3, $rev4);
        
    } else if ($resto_id == 2) {
        $rev1 = array(
            'id' => 5,
            'user_name' => 'Jason D',
            'user_profilepic_url' => 'https://randomuser.me/api/portraits/men/53.jpg',
            'content' => 'Great portion for the price',
            'rating' => 5,
            'date' => '20 Apr 2023'
        );

        $rev2 = array(
            'id' => 6,
            'user_name' => 'Ricky W',
            'user_profilepic_url' => 'https://randomuser.me/api/portraits/men/28.jpg',
            'content' => 'Very delicious',
            'rating' => 5,
            'date' => '15 Apr 2023'
        );

        $rev3 = array(
            'id' => 7,
            'user_name' => 'Jackson W',
            'user_profilepic_url' => 'https://randomuser.me/api/portraits/men/11.jpg',
            'content' => 'Simply the best',
            'rating' => 5,
            'date' => '6 Apr 2023'
        );

        $rev4 = array(
            'id' => 8,
            'user_name' => 'Megan F',
            'user_profilepic_url' => 'https://randomuser.me/api/portraits/women/21.jpg',
            'content' => 'Quick and easy meal.',
            'rating' => 5,
            'date' => '1 Mar 2023'
        );

        $rev_arr = array($rev1, $rev2, $rev3, $rev4);
        
    } else if ($resto_id == 3) {
        $rev1 = array(
            'id' => 9,
            'user_name' => 'Sheldon C',
            'user_profilepic_url' => 'https://randomuser.me/api/portraits/men/14.jpg',
            'content' => 'Good food',
            'rating' => 5,
            'date' => '14 Apr 2023'
        );

        $rev2 = array(
            'id' => 10,
            'user_name' => 'Lauren Y',
            'user_profilepic_url' => 'https://randomuser.me/api/portraits/women/54.jpg',
            'content' => 'Very good service and good food',
            'rating' => 5,
            'date' => '16 Feb 2023'
        );

        $rev3 = array(
            'id' => 11,
            'user_name' => 'Leonard',
            'user_profilepic_url' => 'https://randomuser.me/api/portraits/men/59.jpg',
            'content' => 'I really enjoyed the nasi goreng. Would visit again soon!',
            'rating' => 5,
            'date' => '2 Jan 2023'
        );

        $rev4 = array(
            'id' => 12,
            'user_name' => 'James H',
            'user_profilepic_url' => 'https://randomuser.me/api/portraits/men/70.jpg',
            'content' => 'Wonderful. Really enjoyed my visit',
            'rating' => 5,
            'date' => '18 Dec 2022'
        );

        $rev_arr = array($rev1, $rev2, $rev3, $rev4);
        
    } else {
        $rev1 = array(
            'id' => 13,
            'user_name' => 'Ronald M',
            'user_profilepic_url' => 'https://randomuser.me/api/portraits/men/43.jpg',
            'content' => 'Really good',
            'rating' => 5,
            'date' => '5 Apr 2023'
        );

        $rev2 = array(
            'id' => 14,
            'user_name' => 'Ruth B',
            'user_profilepic_url' => 'https://randomuser.me/api/portraits/women/17.jpg',
            'content' => 'Delicious and many options',
            'rating' => 5,
            'date' => '2 Jan 2023'
        );

        $rev3 = array(
            'id' => 15,
            'user_name' => 'Richard H',
            'user_profilepic_url' => 'https://randomuser.me/api/portraits/men/22.jpg',
            'content' => 'Very filling meal for cheap',
            'rating' => 5,
            'date' => '30 Nov 2022'
        );

        $rev4 = array(
            'id' => 16,
            'user_name' => 'Mandy E',
            'user_profilepic_url' => 'https://randomuser.me/api/portraits/men/26.jpg',
            'content' => 'Satisfied my cravings!',
            'rating' => 5,
            'date' => '7 Sep 2022'
        );

        $rev_arr = array($rev1, $rev2, $rev3, $rev4);
        
    }

    echo json_encode($rev_arr);
}

?>