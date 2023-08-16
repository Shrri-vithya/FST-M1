import pytest


def test_sumList(listget):
    sum = 0
    for i in listget:
        sum += i
    assert sum == 55


