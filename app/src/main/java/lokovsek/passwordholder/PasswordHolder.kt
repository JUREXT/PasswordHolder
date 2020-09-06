package lokovsek.passwordholder

open class PasswordHolder(var id: Int, var holder: String, var password: String, var created_at: Long) {

    override fun toString(): String {
        return "PasswordHolder{" +
                "id=" + id +
                ", holder='" + holder + '\'' +
                ", password='" + password + '\'' +
                ", created_at=" + created_at +
                '}'
    }

}