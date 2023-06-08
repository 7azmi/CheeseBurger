# Tic-Tac-Toe Java Implementation

This repository contains an advanced implementation of the classic game Tic-Tac-Toe in Java. It showcases object-oriented programming concepts such as polymorphism, inheritance, interfaces and abstract classes. It also includes file I/O operations to store the game statistics.

The reason behind this CheeseBurger naming is because it was supposed to be a Chess game but a bit complex for a mini project.

## Features
- Two types of players: Human (manual input) and Bot (random move generator).
- Game statistics are stored in a text file for each match.
- Use of an interface and implementation to abstract game logic.
- Utilization of polymorphism to handle different player types.

## Getting Started

### Prerequisites
1. JDK 11 or higher installed.
2. A Java IDE (optional), such as IntelliJ IDEA or Eclipse.

### How to Run
1. Clone the repository to your local machine.
2. If you're using an IDE, import the project. If not, navigate to the project directory in the command line.
3. Compile the Main.java file.
4. Run the compiled Main file.

## Usage

After you start the game, you'll see an empty game board. The human player uses 'X' as a marker, and the bot uses 'O'. Each player takes a turn to place their marker. If it's the human player's turn, you'll need to input the position where you want to place the marker (1-9). The bot player makes a move automatically.

The game ends when one of the players wins, or when the board is full and it's a draw. The game statistics are stored in a text file named 'gameStats.txt'.

## UML Diagram
![UML Diagram](http://www.plantuml.com/plantuml/png/jPAzJiCm4CTtFuNLgQWa3n0XL7M13f6GEZ0WXejpf5RyKTcN0YfzT-nyO58anCAMtFty_t2ozWIEEgsOD8Jk1GJoEz2u_NexCSvNjVG71UyR2wvUNXNyQ6KTvnfQBEqHb-7qDT-HawO9wyfQXM0Y8VOesaTfbZ-MPyQ40kzxlrwvzygg-5YCOa_F_sWFbIS7WlYGuo5Oe1j2Q70jkYb5L6gGoduO0wJnQH8v1s1GY8aY54AbalUT1lFDOVKxlh7qTxW4QGREatKOxtD7G3wLZXSM-PxCyzkBRrpmpgDFsz7wShne9kMStcWHzgzE4dfEbh7npCr7bitA5dnhzXWuC09dLEeuPzWiN63pFFqZaTK7XHeDURP6KtTQVG80)

## Contributing

Pull requests are welcome. For major changes, please open an issue first to discuss what you would like to change.

## License

This project is licensed under the MIT License. See the LICENSE file for more details.
