sleep 5
if curl customer-core-service:8094 | grep -q 'name'; then
  echo "Tests passed!"
  exit 0
else
  echo "Tests failed!"
  exit 1
fi