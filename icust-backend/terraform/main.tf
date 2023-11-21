provider "aws" {
  region = var.aws_region

  default_tags {
    tags = {
      Name       = "icust-backend"
      Repository = "https://github.com/ericdahl/icust-backend"
    }
  }
}

data "aws_default_tags" "default" {}

locals {
  name = data.aws_default_tags.default.tags["Name"]
}