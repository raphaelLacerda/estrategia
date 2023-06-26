from django.shortcuts import render
from rest_framework import viewsets
from .models import Pessoa
from .serializers import PessoaSerializer

# Create your views here.

class PessoaViewSet(viewsets.ModelViewSet):
    queryset = Pessoa.objects.all()
    serializer_class = PessoaSerializer