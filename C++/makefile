exe:
	g++ -std=c++17 -o out/trivia GameRunner.cpp Game.cpp -I.

test:
	g++ -std=c++17 -o out/triviaTests GameTests.cpp Game.cpp -I.

testg:
	g++ -std=c++17 -o out/triviaGTests TriviaGTests.cpp -I. -I./gmock/include -I./gtest/include -L./gmock/ -L./gtest/ -lgmock_main -lgtest -lgmock -lpthread
