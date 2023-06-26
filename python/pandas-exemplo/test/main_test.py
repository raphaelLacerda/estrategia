from src.main import *


def test_deve_dizer_ola_para_nome():
    msg = say_hello("Raphael")
    assert msg == "Olá Raphael, seja bem-vindo!"