# JavaFX Calculator

This is a simple calculator application built using JavaFX. The app allows users to perform basic arithmetic operations like addition, subtraction, multiplication, and division. The calculator features a graphical user interface (GUI) where users can interact with buttons or use keyboard inputs for calculations.

## Features

- Supports basic arithmetic operations: addition, subtraction, multiplication, and division.
- Clear (C) button to reset the calculator.
- Handles keyboard input for numbers and operators.
- Displays results with a clean and user-friendly interface.
- Error handling for invalid operations like division by zero.

## Technologies Used

- **JavaFX** for building the GUI.
- **Maven** for project management and dependencies.

## Requirements

- Java 11 or higher.
- Maven 3.x or higher.
- JavaFX 17.0.6 or higher.

## Setup

1. Clone the repository or download the source files.

2. Open the project in your favorite IDE (e.g., IntelliJ IDEA or Eclipse).

3. Install dependencies using Maven. You can do this by running:
    ```bash
    mvn clean install
    ```

4. Run the application using Maven with the following command:
    ```bash
    mvn javafx:run
    ```

## Project Structure

- **CalculatorApp.java**: The main class that launches the JavaFX application.
- **CalculatorController.java**: The controller class that handles user interactions, including button clicks and keyboard inputs.
- **calculator.fxml**: The FXML file that defines the layout of the calculator.
- **style.css**: The CSS file that defines the style of the calculator's UI.

### Key FXML Elements

The FXML layout consists of a `GridPane` with buttons for each digit, operator, and functions like Clear (C) and Equals (=). The display is a non-editable `TextField` that shows the current calculation or result.

### Sample Layout:
- 4 rows and 4 columns for the calculator's buttons.
- A display area at the top for showing the current number or result.

## How It Works

- The `CalculatorApp.java` class is the entry point of the application. It loads the `calculator.fxml` layout and applies the `style.css` stylesheet.
- The `CalculatorController.java` class manages the logic for processing input, handling operations, and displaying results.
- The calculator supports both button clicks and keyboard input for numbers and operators.
