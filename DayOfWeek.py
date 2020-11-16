class Solution:
# return string of the day of the week
    import datetime
    def dayOfTheWeek(self, day: int, month: int, year: int) -> str:

        week = ['Monday','Tuesday','Wednesday','Thursday','Friday','Saturday','Sunday']

        # print(day, month, year)
        provided_date = datetime.datetime(year, month, day)
        return week[provided_date.weekday()]
