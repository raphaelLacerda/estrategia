import pyarrow as pa
import pyarrow.compute as pc

if __name__ == '__main__':
    days = pa.array([1, 12, 17, 23, 28], type=pa.int8())
    months = pa.array([1, 3, 5, 7, 1], type=pa.int8())
    years = pa.array([1990, 2000, 1995, 2000, 1995], type=pa.int16())

    # Multiple arrays can be combined in tables to form the columns in tabular
    birthdays_table = pa.table([days, months, years], names = ["days", "months", "years"])
    print(birthdays_table)

    # quantas vezes cada ano aparece
    print(pc.value_counts(birthdays_table["years"]))
    print(pc.max(birthdays_table["years"]))
    print(pc.min(birthdays_table["years"]))
    print(pc.count_distinct(birthdays_table["years"]))