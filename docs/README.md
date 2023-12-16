# 📍ONCALL

## 기능 구현 구조

## VIEW
- InputView : 입력 담당
- OutputView : 출력 담당

## DOMAIN
- 12개월의 총 일수를 지정하고, 휴일을 관리하는 클래스
- 평일 근무자
- 휴일 근무자

## CONTROLLER
- Domain 로직으로부터 데이터를 받아 View로 전달

## UTILS
- [ ] parseToInt -> 월 입력
- [ ] split ","으로

## EXCEPTION
[//]: # (- ErrorMessage : 에러 메세지를 저장.)
- [ ] 근무자의 이름이 5자를 넘긴 경우
- [ ] 최소 5명, 최대 35명을 만족시키지 못한 경우
- [ ] 근무자가 한 줄에 중복인 경우
- [ ] validate ","
- [ ] 평일 비상 근무자와 휴일 비상 근무자의 수가 다른 경우