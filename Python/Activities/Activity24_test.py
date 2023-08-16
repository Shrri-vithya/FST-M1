import pytest


@pytest.fixture
def wallet():
    amount = 0
    return amount


@pytest.mark.parametrize("earned, spent, expecteds", [(30, 10, 20), (20, 2, 18)])
def test_method(wallet, earned, spent, expecteds):
    wallet += earned
    wallet -= spent
    assert wallet == expecteds
