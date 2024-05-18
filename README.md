# Bank API

This is a Spring Boot project for a simple bank API. It allows users to register, add money, transfer money, check balance, take loans, and pay loans.

## Project Structure

- **UserController**: Handles user registration.
- **BankController**: Handles bank operations like adding money, transferring money, checking balance, taking loans, and paying loans.

## Prerequisites

- Java 11 or higher
- Docker
- Docker Compose
- Maven

## Getting Started

### Build and Run the Application

1. **Clone the repository**:
    ```sh
    git clone https://github.com/yourusername/bank-api.git
    cd bank-api
    ```

2. **Build the application using Maven**:
    ```sh
    mvn clean install
    ```

3. **Run the application using Docker Compose**:
    ```sh
    docker-compose up --build
    ```

### API Endpoints

#### User Registration

- **POST /register**
    - Request Body: `UserRegisterRequestDto`
        ```json
        {
            "username": "string",
            "password": "string"
        }
        ```
    - Response: Success message or error message.

#### Bank Operations

- **POST /add**
    - Request Body: `AddMoneyRequestDto`
        ```json
        {
            "username": "string",
            "amount": "number"
        }
        ```
    - Response: Success message or error message.

- **POST /transfer**
    - Request Body: `TransferMoneyRequestDto`
        ```json
        {
            "username": "string",
            "to": "string",
            "amount": "number"
        }
        ```
    - Response: Success message or error message.

- **POST /balance**
    - Request Body: `UserBalanceRequestDto`
        ```json
        {
            "username": "string"
        }
        ```
    - Response: `UserBalanceResponseDto`
        ```json
        {
            "username": "string",
            "own": "number",
            "debt": "number"
        }
        ```

- **POST /takeloan**
    - Request Body: `UserLoanRequestDto`
        ```json
        {
            "username": "string",
            "amount": "number"
        }
        ```
    - Response: Success message or error message.

- **POST /payloan**
    - Request Body: `UserLoanRequestDto`
        ```json
        {
            "username": "string",
            "amount": "number"
        }
        ```
    - Response: Success message or error message.

## Docker Setup

This project uses Docker and Docker Compose for containerization. The Docker setup includes:

- **Dockerfile**: Defines the application's Docker image.
- **docker-compose.yml**: Defines the services, including the application and any dependencies.

### Building and Running with Docker

1. **Build the Docker image**:
    ```sh
    docker build -t bank-api .
    ```

2. **Run the Docker container**:
    ```sh
    docker run -p 8080:8080 bank-api
    ```

3. **Alternatively, use Docker Compose**:
    ```sh
    docker-compose up --build
    ```

## Technologies Used

- Java 17
- Spring Boot
- Docker
- Docker Compose
- Maven

## License

This project is licensed under the MIT License - see the [LICENSE](LICENSE) file for details.
