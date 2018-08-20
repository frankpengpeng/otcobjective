package com.frank.practice.designPattern;

class BuilderPattern {
    private String name;
    private String code;
    private String spec;
    private String remark;
    private String value;
    private String grade;
    private String type;
    private String key;

    public static class Builder{
        private String name;
        private String code;
        private String spec;
        private String remark;
        private String value;
        private String grade;
        private String type;
        private String key;

        public Builder(String name, String code){
            this.name= name;
            this.code = code;
        }

        public Builder setSpec(String spec){
            this.spec = spec;
            return this;
        }
        public Builder setRemark(String remark){
            this.remark = remark;
            return this;
        }
        public Builder setValue(String value){
            this.value = value;
            return this;
        }
        public Builder setGrade(String grade){
            this.grade = grade;
            return this;
        }
        public Builder setType(String type){
            this.type = type;
            return this;
        }
        public Builder key(String key){
            this.key = key;
            return this;
        }
        public BuilderPattern build(){
            return new BuilderPattern(this);
        }
    }

    public BuilderPattern(Builder builder){
        name = builder.name;
        code = builder.code;
        spec = builder.spec;
        remark = builder.remark;
        value = builder.value;
        grade =builder.grade;
        type = builder.type;
        key = builder.key;
    }
}