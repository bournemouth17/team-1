<?php
require_once 'core/init.php';
require_once 'header.php';
$query = "SELECT * FROM incident WHERE incident.incidentId = {$_GET['id']}";
$db = db::getInstance();
$incident = $db->query($query)->results();
$incident = $incident[0];
?>
<body style="zoom: 1;" cz-shortcut-listen="true"><div class="projectbackground" style="transform: translate(0, 0); position:fixed;z-index:-1">
</div>
<div class="row" style="z-index: 1;">
    <a href="" class="btn-flat white-text" style="position:absolute; left:0; padding: 8px 0 0 20px"><i class="material-icons left">arrow_back</i> home</a>
    <div class=" col s12 m8 l6 offset-m2 offset-l3" style="padding:2vw;margin-top:16vw">
        <h2 class="white-text">Incident #<?php echo $incident->incidentId ?></h2>
        <div class="card-panel row">
            <ul class="collection with-header z-depth-3">
                <li class="collection-header"><h4>Description</h4></li>
                <li class="collection-item">
                    <h6><p><?php echo $incident->description ?></p></h6>
                </li>
            </ul>
            <?php
                $query = "SELECT * FROM patient WHERE incidentId = {$_GET['id']}";
                $db = db::getInstance();
                $patient = $db->query($query)->results();
                $patient = $patient[0];
            ?>
            <ul class="collection with-header z-depth-3">
                <li class="collection-header"><h4>Patient</h4></li>
                <li class="collection-item avatar">
                    <i class="material-icons circle">account_circle</i>
                    <span class="title">Name:</span>
                    <h6>
                        <?php echo $patient->name ?>
                    </h6>
                </li>
                <li class="collection-item avatar">
                    <i class="material-icons circle">home</i>
                    <span class="title">Address:</span>
                    <h6>
                            <?php echo $patient->address ?>
                    </h6>
                </li>
                <li class="collection-item avatar">
                    <i class="material-icons circle">new_releases</i>
                    <span class="title">Date of Birth:</span>
                    <h6>
                        <?php echo $patient->dob ?>
                    </h6>
                </li>
                <li class="collection-item avatar">
                    <i class="material-icons circle">phone</i>
                    <span class="title">Telephone Number:</span>
                    <h6>
                        <?php echo $patient->telephoneNumber ?>
                    </h6>
                </li>
                <li class="collection-item avatar">
                    <i class="material-icons circle">history</i>
                    <span class="title">Medical History:</span>
                    <h6>
                        <?php echo $patient->medicalHistory ?>
                    </h6>
                </li>
                <li class="collection-item avatar">
                    <i class="material-icons circle">local_dining</i>
                    <span class="title">Last Meal:</span>
                    <h6>
                        <?php echo $patient->lastMeal ?>
                    </h6>
                </li>
            </ul>
            <?php
            $query = "SELECT * FROM medicineAdministered WHERE incidentId = {$_GET['id']}";
            $db = db::getInstance();
            $dosage = $db->query($query)->results();
            $dosage = $dosage[0];
            ?>
            <ul class="collection with-header z-depth-3">
                <li class="collection-header"><h4>Drugs given:</h4></li>
                <li class="collection-item avatar">
                    <i class="material-icons circle">favorite</i>
                    <span class="title"></span>
                    <h6>Name: <?php echo $dosage->name ?><br>
                    <h6><p>Time: <?php echo $dosage->time ?></p>
                    <h6>Dosage: <?php echo $dosage->dose ?><br>

                </li>
            </ul>
            <?php
            $query = "SELECT * FROM allergy WHERE incidentId = {$_GET['id']}";
            $db = db::getInstance();
            $allergy = $db->query($query)->results();
            $allergy = $allergy[0];
            ?>
            <ul class="collection with-header z-depth-3">
                <li class="collection-header"><h4>Allergies:</h4></li>
                <li class="collection-item avatar">
                    <i class="material-icons circle">nature_people</i>
                    <span class="title"></span>
                    <h6>Name: <?php echo $allergy->title ?><br>
                        <h6><p>Dose: <?php echo $allergy->medication ?></p>

                </li>
            </ul>
        </div>
    </div>
</div>
