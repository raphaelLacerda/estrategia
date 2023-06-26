from django.db import models

# Create your models here.
class Pessoa(models.Model):
    nome = models.CharField(max_length=40)
    idade = models.IntegerField()

    def __str__(self):
        return self.nome