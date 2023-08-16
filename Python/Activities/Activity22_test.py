import pytest
import math


def testSum():
    num1 = 1
    num2 = 3
    assert num1+num2 == 4


def testSub():
    num1 = 5
    num2 = 3
    assert num1-num2 == 2


@pytest.mark.activity
def testMul():
    num1 = 1
    num2 = 3
    assert num1*num2 == 3


@pytest.mark.activity
def test_Div():
    num1 = 4
    num2 = 1
    assert num1/num2 == 4

