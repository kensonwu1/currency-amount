Run:
1. cd to the project root folder in command line.
2. mvn clean install
3. mvn exec:java -Dexec.mainClass=fx.App -Dexec.args="G:\cloudPricing\currency-amount.txt"

Validation:
1. Currency must be be any uppercase 3 letter code such as USD
2. Amount must be valid number such as 100, 080 is allowed for the default simple validation
3. Input string format: <currency> <amount>, such as: USD 100

Exchange rate is mock:
  USD(100),
  CNY(15),
  HKD(13),
  OTHER(0);