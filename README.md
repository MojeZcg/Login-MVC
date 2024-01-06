# MVC Login System

## Overview

This project demonstrates the implementation of a login system using the Model-View-Controller (MVC) design pattern. The entire codebase is written in Java, utilizing the NetBeans IDE for development. The MVC pattern separates the application logic into three interconnected components, enhancing modularity and maintainability.

## Features

- **User Authentication**: Secure login functionality with username and password validation.
- **MVC Architecture**: Well-structured code following the Model-View-Controller design pattern.
- **Java Swing GUI**: Utilizes Java Swing for the graphical user interface.

## Requirements

- Java Development Kit (JDK)
- NetBeans IDE

## Getting Started

1. Clone the repository:

   ```bash
   git clone https://github.com/your-username/mvc-login-system.git
   ```
   
2. Open the project in NetBeans IDE.
3. Build and run the application.

## MVC Components

### 1. Model

- **`ModelAdminUsers.java`**: Manages user data and authentication logic.

### 2. View

- **`Login.java`**: Displays the login interface.

### 3. Controller

- **`ControllerConstruction.java`**: Handles user inputs, communicates with the model, and updates the view accordingly.

## Usage

1. Launch the application.
2. Enter a valid username and password.
3. Click the "Login" button to authenticate.

## Project Structure

```
mvc-login-system/
│
├── src/
│ ├── controller/
│ │ └── ControllerConnection.java
│ │ └── ControllerConstruction.java
│ │
│ ├── model/
│ │ └── ModelAdminUsers.java
│ │ └── ModelConnection.java
│ │ └── ModelConstruction.java
│ │
│ ├── view/
│ │ └── ChangePswd.form
│ │ └── ChangePswd.java
│ │ └── Login.form
│ │ └── Login.java
│ │ └── SignUp.form
│ │ └── SignUp.java
│ │ └── Welcome.form
│ │ └── Welcome.java
│ │ └── cBuild.form
│ │ └── cBuild.java
│ │ └── cHom.form
│ │ └── cHom.java
│
└── README.md
```

## Contribution

Contributions are welcome! If you have suggestions, feature requests, or find any issues, feel free to open an [issue](https://github.com/your-username/mvc-login-system/issues) or submit a [pull request](https://github.com/your-username/mvc-login-system/pulls).

## License

This project is licensed under the [MIT License](LICENSE). Feel free to use, modify, and distribute the code as per the license terms.
