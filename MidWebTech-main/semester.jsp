<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Semester Management</title>
    <link rel="stylesheet" href="styles.css">
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css">
    <style>
        /* Additional CSS styles */
        body {
            font-family: Arial, sans-serif;
            margin: 0;
            padding: 0;
            display: flex;
            justify-content: center;
            align-items: center;
            height: 100vh;
            background-color: #f0f0f0;
        }

        .container {
            max-width: 800px;
            width: 100%;
            margin: 20px;
        }

        .semester-card {
            background-color: #fff;
            border-radius: 10px;
            box-shadow: 0px 4px 10px rgba(0, 0, 0, 0.1);
            padding: 20px;
            margin-bottom: 20px;
        }

        .semester-form {
            display: flex;
            flex-wrap: wrap;
        }

        .form-group {
            flex: 1 1 calc(50% - 20px);
            margin-right: 20px;
            margin-bottom: 20px;
        }

        .form-group label {
            font-weight: bold;
        }

        .form-group input[type="text"],
        .form-group input[type="date"] {
            width: calc(100% - 10px);
            padding: 10px;
            border: 1px solid #ccc;
            border-radius: 5px;
        }

        .form-group button {
            background-color: #007bff;
            color: #fff;
            border: none;
            padding: 10px 20px;
            border-radius: 5px;
            cursor: pointer;
            transition: background-color 0.3s ease;
        }

        .form-group button:hover {
            background-color: #0056b3;
        }

        .table {
            width: 100%;
            border-collapse: collapse;
            margin-top: 20px;
        }

        .table th,
        .table td {
            border: 1px solid #ccc;
            padding: 10px;
        }

        .table th {
            background-color: #f0f0f0;
            text-align: left;
        }

        .table tr:nth-child(even) {
            background-color: #f9f9f9;
        }
    </style>
</head>
<body>
<!--    <div class="container">
        <div class="semester-card">
            <h1>Semester Management</h1>
            <form action="semester" method="post" class="semester-form">
                <div class="form-group">
                    <label for="semesterName">Semester Name</label>
                    <input type="text" id="semesterName" name="semesterName" required>
                </div>
                <div class="form-group">
                    <label for="startingDate">Starting Date</label>
                    <input type="date" id="startingDate" name="startingDate" required>
                </div>
                <div class="form-group">
                    <label for="endDate">End Date</label>
                    <input type="date" id="endDate" name="endDate" required>
                </div>
                <div class="form-group">
                    <button type="submit" >Save</button>
                </div>
            </form>
        </div>
        <table class="table" id="semesterTable">
            <thead>
                <tr>
                    <th>Semester ID</th>
                    <th>Semester Name</th>
                    <th>Starting Date</th>
                    <th>End Date</th>
                    <th>Action</th>  New column for action buttons 
                </tr>
            </thead>
            <tbody>
                
            </tbody>
        </table>
    </div>
     JavaScript to set the action parameter 
    
    <script>
        // Function to populate the table with semester data
        function populateSemesterTable(semesters) {
            var tableBody = document.querySelector("#semesterTable tbody");
            tableBody.innerHTML = ""; // Clear existing table rows

            // Loop through each semester in the list
            semesters.forEach(function(semester) {
                // Create a new table row
                var row = tableBody.insertRow();

                // Insert cells for Semester ID, Name, Starting Date, End Date, and Actions
                var idCell = row.insertCell();
                var nameCell = row.insertCell();
                var startDateCell = row.insertCell();
                var endDateCell = row.insertCell();
                var actionsCell = row.insertCell();

                // Set the text content of each cell
                idCell.textContent = semester.semesterId;
                nameCell.textContent = semester.semesterName;
                startDateCell.textContent = semester.startingDate;
                endDateCell.textContent = semester.endDate;

                // Create delete and update icons with Bootstrap classes
                var deleteIcon = document.createElement("span");
                deleteIcon.classList.add("btn", "btn-danger", "btn-sm", "mr-2");
                deleteIcon.innerHTML = '<i class="bi bi-trash"></i>';
                deleteIcon.onclick = function() {
                    // Call a function to handle delete action with the semester ID
                    handleDelete(semester.semesterId);
                };

                var updateIcon = document.createElement("span");
                updateIcon.classList.add("btn", "btn-primary", "btn-sm");
                updateIcon.innerHTML = '<i class="bi bi-eye"></i>';
                updateIcon.onclick = function() {
                    // Call a function to handle update action with the semester ID
                    handleUpdate(semester.semesterId);
                };

                // Append icons to actions cell
                actionsCell.appendChild(deleteIcon);
                actionsCell.appendChild(updateIcon);
            });
        }

        // Function to handle delete action
        function handleDelete(semesterId) {
            // Implement delete action here using AJAX or redirect to servlet with semesterId
            alert("Delete semester with ID: " + semesterId);
        }

        // Function to handle update action
        function handleUpdate(semesterId) {
            // Implement update action here using AJAX or redirect to servlet with semesterId
            alert("Update semester with ID: " + semesterId);
        }

        // Call this function when the page loads to populate the table initially
        window.onload = function() {
            // Fetch the list of semesters from the server using AJAX
            fetch("semester?action=list")
                .then(response => response.json())
                .then(data => populateSemesterTable(data));
        };
</script>-->
    <div class="container">
        <div class="semester-card">
            <h1>Semester Management</h1>
            <form action="semester" method="post" class="semester-form">
                <input type="hidden" name="action" value="create"> <!-- Action for creating a new semester -->
                <div class="form-group">
                    <label for="semesterName">Semester Name</label>
                    <input type="text" id="semesterName" name="semesterName" required>
                </div>
                <div class="form-group">
                    <label for="startingDate">Starting Date</label>
                    <input type="date" id="startingDate" name="startingDate" required>
                </div>
                <div class="form-group">
                    <label for="endDate">End Date</label>
                    <input type="date" id="endDate" name="endDate" required>
                </div>
                <div class="form-group">
                    <button type="submit" class="btn btn-primary">Save</button>
                </div>
            </form>
        </div>
        <table class="table" id="semesterTable">
            <thead>
                <tr>
                    <th>Semester ID</th>
                    <th>Semester Name</th>
                    <th>Starting Date</th>
                    <th>End Date</th>
                    <th>Actions</th>
                </tr>
            </thead>
            <tbody>
                <!-- Use JSTL forEach to iterate over semesters and populate table -->
                <c:forEach items="${semesters}" var="semester">
                    <tr>
                        <td>${semester.semesterId}</td>
                        <td>${semester.semesterName}</td>
                        <td>${semester.startingDate}</td>
                        <td>${semester.endDate}</td>
                        <td>
                            <!-- Update form -->
                            <form action="semester" method="get">
                                <input type="hidden" name="action" value="edit">
                                <input type="hidden" name="semesterId" value="${semester.semesterId}">
                                <button type="submit" class="btn btn-primary">Update</button>
                            </form>
                            <!-- Delete form -->
                            <form action="semester" method="post">
                                <input type="hidden" name="action" value="delete">
                                <input type="hidden" name="semesterId" value="${semester.semesterId}">
                                <button type="submit" class="btn btn-danger">Delete</button>
                            </form>
                        </td>
                    </tr>
                </c:forEach>
            </tbody>
        </table>
    </div>
</body>
</html>
