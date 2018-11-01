#include "gtest/gtest.h"
#include "gmock/gmock.h"

TEST(Game, Failing) {
	EXPECT_EQ(0, 1);
}
