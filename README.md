# Project README

## Prerequisites

Before running the project, make sure you have the following tools installed on your system:

1. **Go Installation**
   - Download and install Go from the official [Go website](https://golang.org/dl/).
   - Follow the instructions for your operating system to complete the installation.

2. **Hey Installation**
   - Install `hey`, a tool for generating HTTP load, by following the instructions below:
     - **Using Go**:
       ```bash
       go install github.com/rakyll/hey@latest
       ```
     - **Download Binary**:
       - Download the `hey` binary from the [official GitHub releases page](https://github.com/rakyll/hey/releases).
       - Extract the binary and add it to your system's PATH.

## Hey Commands

Below are the commands to execute different HTTP methods using `hey`:

1. **Execute HTTP method without virtual threads:**

   This command sends 80 HTTP requests concurrently with a timeout of 100 seconds to `http://localhost:8080`:

   ```bash
   hey -n 80 -c 80 -t 100 http://localhost:8080

2. **Execute HTTP method with a thread pool:**

   This is intended to simulate the behavior of a system using a thread pool for handling requests:

   ```bash
   hey -n 1 -c 1 -t 100 http://localhost:8080/pool

3. **Execute HTTP method without virtual threads:**

   This simulates the behavior of a system using virtual threads:

   ```bash
   hey -n 1 -c 1 -t 100 http://localhost:8080/virtual
