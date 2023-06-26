import datetime
import arrow

if __name__ == '__main__':
    dataAntiga = datetime.datetime.now()
    print(dataAntiga)
    uma_hora = datetime.timedelta(hours=1)
    dataAntiga = dataAntiga + uma_hora
    print(dataAntiga)

    print(arrow.now())
    print(arrow.now('America/Sao_Paulo'))
    print(arrow.utcnow())
    data = arrow.get('2013-05-11T21:23:58.970460+07:00')
    print(data)
    print(data.shift(hours=1))
    print(data.humanize(locale='pt-br'))
    print(data.format('DD/MM/YYYY HH:mm:ss'))
