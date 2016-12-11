sleep 5
if curl customer-service:8094/api/core/customers/cust1 | grep -q 'name'; then
  echo "Tests passed!"
  exit 0
else
  echo "Tests failed!"
  exit 1
fi