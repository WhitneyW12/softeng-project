cd demos
cd dollarrestaurantdemo
javac -cp .;..\..\build\libs\softeng-project-1.0.jar DollarRestaurant.java
java -cp .;..\..\build\libs\softeng-project-1.0.jar DollarRestaurant spaghetti -d tea 1 -s 3 -a pickles -e cookies -t
pause