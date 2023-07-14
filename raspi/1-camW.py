#! /usr/bin/env python
# 카메라로부터사진찍기
import cv2

cap = cv2.VideoCapture(0)		# 0번카메라객체 생성(0:웹캠, -1:pi캠)
cap.isOpened()							# 카메라열기
cap.set(3, 643)							# 윈도우크기설정
cap.set(4, 480)

ret, frame = cap.read()			# 카메라로부터프레임읽기
frame = cv2.flip(frame, 1)	# 1:좌우대칭, 0:상하대칭, -1:상하좌우대칭

cv2.imwrite("self camera test.jpg", frame)	# 프레임저장

cap.release()								# 카메라닫기
cv2.destroyAllWindows()			#	윈도우닫기
