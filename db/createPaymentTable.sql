CREATE TABLE Payment
(cardNumber VARCHAR(16) NOT NULL,
userEmail VARCHAR(50) NOT NULL,
cardExpiry VARCHAR(5),
cardCVC VARCHAR(3),
PRIMARY KEY (cardNumber),
FOREIGN KEY (userEmail) REFERENCES USERS(Email));