# 정렬

## 정렬 알고리즘
- 버블 정렬 (bubble) : 데이터의 인접 요소끼리 비교하고, swap 연산을 수행하며 정렬하는 방식
- 선택 정렬 (selection) : 대상에서 가장 크거나 작은 데이터를 찾아가 선택을 반복하면서 정렬하는 방식
- 삽입 정렬 (insertion) : 대상을 선택해 정렬된 영역에서 선택 데이터의 적절한 위치를 찾아 삽입하면서 정렬하는 방식
- 퀵 정렬 (quick) : pivot 값을 선정해 정렬된 영역에서 선택 데이터의 적절한 위치를 찾아 삽입하면서 정렬하는 방식
- 병합 정렬 (merge) : 이미 정렬된 부분 집합들을 효율적으로 병합해 전체를 정렬하는 방식
- 기수 정렬 (radix) : 데이터의 자릿수를 바탕으로 비교해 데이터를 정렬하는 방식

## 버블 정렬
- 버블 정렬은 두 인접한 데이터의 크기를 비교해 정렬하는 방법
- 시간 복잡도 : O(n^2)
- 간단하게 구현할 수 있지만, 다른 정렬 알고리즘보다 속도가 느린 편
- 버블 정렬 과정
  1. 비교 연산이 필요한 루프 범위 설정
  2. 인접한 데이터 값을 비교
  3. swap 조건에 부합하면 swap 연산 수행
  4. 루프 범위가 끝날 때까지 2~3 반복
  5. 정렬 영역을 설정, 다음 루프 실행할 때는 이 영역을 제외
  6. 비교 대상이 없을 때까지 1~5를 반복
- 만약 특정한 루프의 전체 영역에서 swap이 한 번도 발생하지 않았다면 그 영역 뒤에 있는 데이터가 모두 정렬됐다는 뜻이므로 프로세스를 종료해도 된다.
