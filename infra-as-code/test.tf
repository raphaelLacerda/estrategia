provider "cloudflare" {
  email = "you@example.com"
  token = "your-api-key"
}

variable "domain" {
  default = "example.com"
}

resource "cloudflare_record" "www" {
  domain  = "${var.domain}"
  name    = "www"
  value   = "203.0.113.10"
  type    = "A"
  proxied = true
}