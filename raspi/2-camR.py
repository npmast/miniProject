#! /usr/bin/env python
# 이미지출력
import cv2

image = "./self camera test.jpg"

gray_img = cv2.imread(image, cv2.IMREAD_GRAYSCALE)	#이미지를 그레이스케일로읽어온다

cv2.imshow("selca", gray_img)		# 이미지출력
cv2.waitKey(0)									# 키입력까지대기
cv2.destroyAllWindows()
