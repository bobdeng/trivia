#define DOCTEST_CONFIG_IMPLEMENT_WITH_MAIN

#include "doctest.h"
#include <iostream>
#include <algorithm>

using namespace std;

TEST_CASE ("fails") {
            CHECK(0 == 1);
}