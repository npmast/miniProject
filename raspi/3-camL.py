#! /usr/bin/env python
# 실시간영상읽기
import numpy as np
import cv2

def video_read():
	try:
		print('cam start')
		cap = cv2.VideoCapture(0)
	except:
		print('cam failed')
		return

	if cap.isOpened():
		while True:
			ret, frame = cap.read()	
			if not ret:
				print('Video Read error')
				break
			cv2.imshow('Frame', frame)

			if cv2.waitKey(1) & 0xFF == ord('q'):		# ord()함수는 아스키값을반환한다.
				break

	cap.release()
	cv2.destroyAllWindows()

if __name__ == "__main__":
	video_read()
