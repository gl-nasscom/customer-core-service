sleep 60
if curl customer:8094/api/core/customers/cust1 | grep -q 'name'; then
  echo "Tests passed!"
  exit 0
else
  echo "Tests failed!"
  exit 1
fi
